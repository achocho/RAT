In this project I have made simple trojan horse using Java ,SQL and P2P. I have managed to overcome windows security because of flaw in the firewall which allows outgoing connections all the time but not ingoing and I manged to overcome this issue 
bu using SQL which for  some reason is allowed as ingoing connection and the application jjust checks for changes in the SQL database after the change is made which is the command it processes it and sends the data to the hacker.

The project includes 3 different files:
Server-This is the app that the hacker is going to work with
Client-This is the app which will be executed on the victims computer.
Config-This is the app which will bound the 2 above together.

In the RAT there are several main functionalities:
1-See all infected computers by your RAT(That means my Server app which can be bounded to multiple Client apps)
2-See all files and directories on the victims computer
3-Download files from the victims computer

This is for now in the short future I may upload and the database(not because I am too lazy too recover it!!).

The only thing I forgot to mention is that you need to have running server for the database.
