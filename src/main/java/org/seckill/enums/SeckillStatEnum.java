package org.seckill.enums;

/**
 * 使用枚举表示数据常量
 * Created by wutongpeng on 2017/1/16.
 */
public enum SeckillStatEnum {

    SUCCESS(1,"秒杀成功"),
    END(0,"秒杀结果"),
    REPEAT_KILL(-1,"重复秒杀"),
    INNER_ERROR(-2,"系统异常"),
    DATA_REWRITE(-3,"数据篡改");

    private int state;

    private String stataInfo;

    SeckillStatEnum(int state, String stataInfo) {
        this.state = state;
        this.stataInfo = stataInfo;
    }

    public int getState() {
        return state;
    }

    public String getStataInfo() {
        return stataInfo;
    }

    public static SeckillStatEnum stateOf(int index){
        for(SeckillStatEnum state : values()){
            if(state.getState() == index){
                return state;
            }
        }
        return null;
    }
}
