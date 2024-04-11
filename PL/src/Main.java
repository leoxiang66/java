/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        BaseProposition p = new BaseProposition(true);
        BaseProposition q = new BaseProposition(true);
        
        // boolean left = neg.unaOp(and.binOp(neg.unaOp(p), q) )


        System.out.println(p.eval());

        boolean left = new And(
        (new Negation(new And(new Negation(p), q))),
                (new Or(p, q))).eval();
        
        System.out.println(left);

        
    }
}