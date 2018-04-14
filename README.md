# MultiParty-Cordapp
A Corda app for transactions between multiple parties and notary. 

## Dapp contains three parts:

* ### TokenState 
      States define shared facts on the ledger. TokenState, will define a token.
* ### TokenTransaction 
      Contracts govern how states evolve over time. TokenContract, will define how TokenStates evolve.
* ### TokenFlow 
      Flows automate the process of updating the ledger.

## Commands to deploy the dapp:
  1. `gradlew.bat deployNodesJava` - Builds a test network of nodes
  2. `build\nodes\runnodes.bat` - Start the nodes. Currently starts 3 parties (Party A,B and C) and one notary.
  3. `flow start TokenFlow recipient: PartyB, amount: 99` - This command on Party A's terminal to issue 99 tokens to Party B from A. 
  4. `run vaultQuery contractStateType: bootcamp.TokenState` - To view tokens on both nodes' vault. 
