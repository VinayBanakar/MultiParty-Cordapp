package java_multiparty;

import net.corda.core.contracts.Command;
import net.corda.core.contracts.CommandData;
import net.corda.core.contracts.Contract;
import net.corda.core.transactions.LedgerTransaction;

/* Our contract, governing how our state will evolve over time.
 * See src/main/kotlin/examples/ExampleContract.java for an example. */
public class TokenContract implements  Contract{
    public static String ID = "java_multiparty.TokenContract";
    public static class Issue implements CommandData { }
    @Override
    public void verify(LedgerTransaction tx) throws IllegalArgumentException{
        Command<CommandData> cmd = tx.getCommand(0);
        if(tx.getInputStates().size() != 0)throw new IllegalArgumentException("Should have no inputs");
        if (tx.getOutputStates().size() != 1) throw new IllegalArgumentException("Should have one output");
        if(tx.getCommands().size() != 1) throw new IllegalArgumentException("There should only be one command");

        TokenState output = (TokenState) tx.getOutputStates().get(0);
        if(output.getAmount() < 0) throw new IllegalArgumentException("Transaction amount should be greater then 0");
        if(!(cmd.getSigners().contains(output.getIssuer().getOwningKey()))) throw new IllegalArgumentException(("Only the issuer should be the signer"));
        if(!(cmd.getValue() instanceof TokenContract.Issue)) throw new IllegalArgumentException("Command should be of instance Issue");
    }
}