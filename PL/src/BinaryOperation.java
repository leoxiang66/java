/**
 * Operation
 */
public abstract class BinaryOperation extends Proposition {
    protected Proposition p1;
    protected Proposition p2;

    public BinaryOperation(Proposition p1, Proposition p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    abstract public boolean binOp(Proposition p1, Proposition p2);

    @Override
    public boolean eval() {
        // TODO Auto-generated method stub
        return this.binOp(this.p1,this.p2);
    }

    
    
}