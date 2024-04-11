public class Biconditional extends BinaryOperation{

    public Biconditional(Proposition p1, Proposition p2) {
        super(p1, p2);
        //TODO Auto-generated constructor stub
    }

    @Override
    public boolean binOp(Proposition p1, Proposition p2) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'binOp'");

        Implication imply1 = new Implication(p1,p2);
        Implication imply2 = new Implication(p2,p1);
        if (imply1.eval() == true && imply2.eval()==true) {
            return true;
        }

        return false;
    }
    
}
