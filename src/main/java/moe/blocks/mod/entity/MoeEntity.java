package moe.blocks.mod.entity;

import moe.blocks.mod.client.Animations;
import moe.blocks.mod.entity.ai.automata.States;
import moe.blocks.mod.entity.ai.automata.state.BlockStates;
import moe.blocks.mod.entity.ai.automata.state.Deres;
import moe.blocks.mod.entity.partial.CharacterEntity;
import moe.blocks.mod.init.MoeBlocks;
import moe.blocks.mod.init.MoeTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Pose;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.LanguageMap;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import java.util.Optional;

public class MoeEntity extends CharacterEntity {
    public static final DataParameter<Optional<BlockState>> BLOCK_STATE = EntityDataManager.createKey(MoeEntity.class, DataSerializers.OPTIONAL_BLOCK_STATE);
    public static final DataParameter<Float> SCALE = EntityDataManager.createKey(MoeEntity.class, DataSerializers.FLOAT);
    protected CompoundNBT extraBlockData = new CompoundNBT();

    public MoeEntity(EntityType<MoeEntity> type, World world) {
        super(type, world);
    }

    @Override
    public void registerData() {
        super.registerData();
        this.dataManager.register(BLOCK_STATE, Optional.of(Blocks.AIR.getDefaultState()));
        this.dataManager.register(SCALE, 1.0F);
    }

    @Override
    public int getBaseAge() {
        return (int) (this.getScale() * 5) + 13;
    }

    @Override
    public void notifyDataManagerChange(DataParameter<?> key) {
        if (BLOCK_STATE.equals(key)) { this.setNextState(States.BLOCK_STATE, BlockStates.get(this.getBlockData()).state); }
        if (SCALE.equals(key)) { this.recalculateSize(); }
        super.notifyDataManagerChange(key);
    }

    @Override
    public void writeAdditional(CompoundNBT compound) {
        compound.putInt("BlockData", Block.getStateId(this.getBlockData()));
        compound.put("ExtraBlockData", this.getExtraBlockData());
        compound.putFloat("Scale", this.getScale());
        super.writeAdditional(compound);
    }

    @Override
    public void readAdditional(CompoundNBT compound) {
        this.setBlockData(Block.getStateById(compound.getInt("BlockData")));
        this.setExtraBlockData((CompoundNBT) compound.get("ExtraBlockData"));
        this.setScale(compound.getFloat("Scale"));
        super.readAdditional(compound);
    }

    public Gender getGender() {
        return this.getBlockData().isIn(MoeTags.MALE_MOES) ? Gender.MASCULINE : Gender.FEMININE;
    }

    @Override
    public String getFamilyName() {
        String key = String.format("entity.moeblocks.%s", this.getBlockName());
        LanguageMap map = LanguageMap.getInstance();
        if (!map.func_230506_b_(key)) { key = String.format("block.%s", this.getBlockName()); }
        return map.func_230503_a_(key);
    }

    @Override
    public String getHonorific() {
        if (this.getBlockData().isIn(MoeTags.FULLSIZED_MOES)) { return super.getHonorific(); }
        if (this.getBlockData().isIn(MoeTags.BABY_MOES)) { return "tan"; }
        return this.getScale() < 1.0F ? "tan" : super.getHonorific();
    }

    public CompoundNBT getExtraBlockData() {
        return this.extraBlockData;
    }

    public void setExtraBlockData(CompoundNBT compound) {
        this.extraBlockData = compound == null ? new CompoundNBT() : compound;
    }

    @Override
    public BlockState getBlockData() {
        return this.dataManager.get(BLOCK_STATE).orElseGet(() -> super.getBlockData());
    }

    public void setBlockData(BlockState state) {
        this.dataManager.set(BLOCK_STATE, Optional.of(state));
    }

    @Override
    protected void dropLoot(DamageSource cause, boolean player) {
        Block.spawnDrops(this.getBlockData(), this.world, this.getPosition(), this.getTileEntity(), cause.getTrueSource(), ItemStack.EMPTY);
        super.dropLoot(cause, player);
    }

    @Override
    public boolean isInvulnerableTo(DamageSource source) {
        return super.isInvulnerableTo(source) || source == DamageSource.DROWN;
    }

    public TileEntity getTileEntity() {
        return this.getBlockData().hasTileEntity() ? TileEntity.readTileEntity(this.getBlockData(), this.getExtraBlockData()) : null;
    }

    public boolean isBlockGlowing() {
        return this.getBlockData().isIn(MoeTags.GLOWING_MOES);
    }

    public float[] getEyeColor() {
        int[] colors = this.getAuraColor();
        float[] b = this.getRGB(colors[0]);
        float[] a = this.getRGB(colors[1]);
        float[] rgb = new float[3];
        for (int i = 0; i < rgb.length; ++i) {
            rgb[i] = (b[i] + a[i]) / 2.0F;
        }
        return rgb;
    }

    private float[] getRGB(int hex) {
        float r = ((hex & 0xff0000) >> 16) / 255.0F;
        float g = ((hex & 0xff00) >> 8) / 255.0F;
        float b = ((hex & 0xff) >> 1) / 255.0F;
        return new float[]{r, g, b};
    }

    private int[] getAuraColor() {
        MaterialColor block = this.getBlockData().getMaterial().getColor();
        MaterialColor aura = Deres.getAura(this.getDere());
        return new int[]{block.colorValue, aura.colorValue};
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState block) {
        this.playSound(MoeBlocks.getStepSound(this.getBlockData()), 0.15F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
        super.playStepSound(pos, block);
    }

    @Override
    public boolean isImmuneToFire() {
        return this.getBlockData().isFlammable(this.world, this.getPosition(), this.getHorizontalFacing());
    }

    @Override
    public String getGivenName() {
        String key = String.format("entity.moeblocks.%s.name", this.getBlockName());
        LanguageMap map = LanguageMap.getInstance();
        if (!map.func_230506_b_(key)) { return super.getGivenName(); }
        return map.func_230503_a_(key);
    }

    public String getBlockName() {
        ResourceLocation block = MoeBlocks.get(this.getBlockData().getBlock()).getRegistryName();
        return String.format("%s.%s", block.getNamespace(), block.getPath());
    }

    @Override
    public float getSoundPitch() {
        float hardness = (1.0F - (float) (this.getAttributeValue(Attributes.ARMOR) + 1.0F) / 31.0F) * 0.25F;
        return super.getSoundPitch() + hardness + (1.0F - this.getScale());
    }

    @Override
    public EntitySize getSize(Pose pose) {
        return super.getSize(pose).scale(this.getScale());
    }

    public float getScale() {
        return this.dataManager.get(SCALE);
    }

    public void setScale(float scale) {
        this.dataManager.set(SCALE, scale);
    }

    @Override
    protected float getStandingEyeHeight(Pose pose, EntitySize size) {
        return 0.908203125F * this.getScale();
    }
}
