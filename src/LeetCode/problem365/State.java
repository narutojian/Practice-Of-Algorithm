package LeetCode.problem365;

import java.util.Objects;

/**
 * 状态类
 * 用来描述两个水壶的状态，即两个水壶装水多少
 */
public class State {
    private int remainX;
    private int remainY;

    public State(int x, int y) {
        remainX = x;
        remainY = y;
    }

    public int getRemainX() {
        return remainX;
    }

    public void setRemainX(int remainX) {
        this.remainX = remainX;
    }

    public int getRemainY() {
        return remainY;
    }

    public void setRemainY(int remainY) {
        this.remainY = remainY;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        State state = (State)obj;
        return (this.remainX == state.remainX && this.remainY == state.remainY);
    }

    @Override
    public int hashCode() {
        return Objects.hash(remainX,remainY);
    }
}
