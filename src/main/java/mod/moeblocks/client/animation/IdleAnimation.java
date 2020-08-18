package mod.moeblocks.client.animation;

import mod.moeblocks.client.Animations;
import mod.moeblocks.client.model.MoeModel;
import mod.moeblocks.entity.MoeEntity;
import mod.moeblocks.entity.util.Deres;
import net.minecraft.util.math.MathHelper;

public class IdleAnimation extends Animation {
    @Override
    public void setMoeRotationAngles(MoeModel model, MoeEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks) {
        if (!entity.isSwingInProgress && limbSwingAmount - entity.prevLimbSwingAmount == 0.0F) {
            Deres dere = (Deres) entity.getDere().getKey();
            switch (dere) {
            case HIMEDERE:
                model.rightLeg.rotateAngleY = Math.abs(MathHelper.cos(ageInTicks * 0.125F)) * 0.5F;
                model.leftArm.rotateAngleZ = -(model.rightArm.rotateAngleZ = 0.5F);
                break;
            case KUUDERE:
                model.rightArm.rotateAngleX = model.leftArm.rotateAngleX = -0.6F;
                model.leftArm.rotateAngleZ = -(model.rightArm.rotateAngleZ = -0.8F);
                break;
            case TSUNDERE:
                model.leftLeg.rotateAngleZ = -(model.rightLeg.rotateAngleZ = 0.1F);
                model.rightArm.rotateAngleX = model.leftArm.rotateAngleX = 0.0F;
                model.leftArm.rotateAngleZ = -(model.rightArm.rotateAngleZ = 0.9F);
                break;
            case YANDERE:
                break;
            case DEREDERE:
                model.body.rotateAngleY = MathHelper.cos(ageInTicks * 0.125F) * 0.1F;
                model.leftLeg.rotateAngleZ = -(model.rightLeg.rotateAngleZ = -0.1F);
                model.rightArm.rotateAngleX = model.leftArm.rotateAngleX = 0.6F;
                model.leftArm.rotateAngleZ = -(model.rightArm.rotateAngleZ = -0.8F);
                break;
            case DANDERE:
                model.leftLeg.rotateAngleZ = -(model.rightLeg.rotateAngleZ = -0.1F);
                model.rightArm.rotateAngleX = model.leftArm.rotateAngleX = -0.6F;
                model.leftArm.rotateAngleZ = -(model.rightArm.rotateAngleZ = -0.8F);
                break;
            }
        }
    }

    @Override
    public Animations getKey() {
        return Animations.IDLE;
    }
}
