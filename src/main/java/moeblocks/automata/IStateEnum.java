package moeblocks.automata;

import moeblocks.entity.AbstractNPCEntity;

public interface IStateEnum<E extends AbstractNPCEntity> {
    IState getState(E applicant);
    
    String toKey();
    
    IStateEnum<E> fromKey(String key);
    
    IStateEnum<E>[] getKeys();
}
