/**
 * Operation
 */
public abstract class UnaryOperation extends Proposition {
    protected Proposition p1;

    public UnaryOperation(Proposition p1) {
        this.p1 = p1;
    }

    abstract public boolean unaOp(Proposition p1);

    @Override
    public boolean eval() {
        // TODO Auto-generated method stub
        return this.unaOp(this.p1);
    }

    
    
}