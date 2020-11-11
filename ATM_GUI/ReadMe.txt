
I have stored the data of 9 customers using sqlite database.
I linked the database to my java project using jdbc.
So, this works only for the 9 customer's data that I stored in it.
The .sqlite file is also there in my folder.
There you can find the data of those 9 customers.

I also used swing gui.
I used different JFrames to get the interface.
It provides options to cheak Balance , change pin , transfer money to other accounts
by taking their account no. , block my card ( can't be unblocked from the atm ) , deposit 
or withdraw money.

deposit or withdraw money is successful only if the entered amount is a multiple of 100.

Main.java is the same as the previously submitted one.
Some of them are useless now , because they are implemented now along with the gui in other classes.
So, I just commented them.
atm extends customer. ( this is of no use )
I did this last time.
So I just left it like that without changing.
Every input field has 0 in it. So we have to clear it and enter the details.

4-digit OTP is printed in the console
 
Main.java has the connection to the database.
Different classes are created to get different frames.


