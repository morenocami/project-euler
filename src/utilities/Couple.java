package utilities;

public class Couple<X, Y> {
    private X x;
    private Y y;

    public Couple(X x, Y y) {
        this.x = x;
        this.y = y;
    }

    public void set(X x, Y y) {
        this.x = x;
        this.y = y;
    }

    public X getX() {
        return x;
    }

    public void setX(X x) {
        this.x = x;
    }

    public Y getY() {
        return y;
    }

    public void setY(Y y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Couple)) return false;

        Couple<?, ?> couple = (Couple<?, ?>) o;

        if (!getX().equals(couple.getX())) return false;
        if (!getY().equals(couple.getY())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = getX().hashCode();
        result = 31 * result + getY().hashCode();
        return result;
    }
}