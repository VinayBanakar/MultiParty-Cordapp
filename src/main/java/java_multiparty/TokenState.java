package java_multiparty;

import com.google.common.collect.ImmutableList;
import net.corda.core.contracts.ContractState;
import net.corda.core.identity.AbstractParty;
import net.corda.core.identity.Party;

import java.util.List;

/* Our state, defining a shared fact on the ledger.
 * See src/main/kotlin/examples/IAmAState.java and
 * src/main/kotlin/examples/IAmAlsoAState.java for examples. */
public class TokenState implements ContractState{

    private Party Issuer;
    private Party Recipient;
    private  int Amount;

    public TokenState(Party issuer, Party recipient, int amount){
        this.Issuer = issuer;
        this.Recipient = recipient;
        this.Amount = amount;
    }
    public Party getIssuer(){
        return Issuer;
    }
    public Party getRecipient(){
        return Recipient;
    }
    public int getAmount(){
        return Amount;
    }

    public void setIssuer(Party issuer) {
        Issuer = issuer;
    }

    public void setRecipient(Party recipient){
        Recipient = recipient;
    }
    public List<AbstractParty> getParticipants(){
        return ImmutableList.of(Issuer, Recipient);
    }
}