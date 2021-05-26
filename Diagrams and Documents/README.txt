
How to compile the game
Precompiled Jar File
cd "location" 
java -jar bjs185_han72_IslandTrader.jar

From the source code:
Use cd command to enter src folder
If ./bin/ doesn't exist:
mkdir ./bin/ && cp -r ./Images ./bin && javac -d bin ./backEnd/*.java ./exceptions/*.java ./gui/*.java && java -cp bin backEnd.game

If ./bin/ is not empty:
rm -r ./bin/* && cp -r ./Images ./bin && javac -d bin ./backEnd/*.java ./exceptions/*.java ./gui/*.java && java -cp bin backEnd.game

If ./bin/ is empty:
cp -r ./Images ./bin && javac -d bin ./backEnd/*.java ./exceptions/*.java ./gui/*.java && java -cp bin backEnd.game



How to play:
* Choose your name (length between 3 and 15 characters, only letters and spaces, max one space in a row and can?t start or end with a space)
* Pick the number of days you want to play (or select Unlimited mode)
* Select a ship and an island to start on
* When choosing a destination, hover over the islands to see their characteristics in terms of trading items
* Click onto different islands that are available to sail to view the options for routes
* Buy items and weapons to trade with other stores
* Weapons can increase the attack multiplier (less chance of being killed by pirates)
* Buy special items and sell for a higher price to the other stores

Tips:
* Buy common items from a cheaper store and sell them to a more expensive store to earn profit.
* Typically, the selling price is lower than the purchasing price for the player
* Buy rum to stop pirates stealing your items

