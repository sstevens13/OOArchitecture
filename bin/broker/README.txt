JAVA = programming language

The broker class maintains a list of all brokers (identified by string OrbId).
The broker forwards the stringified CallMessage to the broker whose OrbID matches
the CallMessage's target (getTarget()).

You can select any server to send a message to. If the server is not available, the 
client will be notified after making the method call.

The program will not allow input of numbers larger or smaller than an int. It will
allow adding two int's where the sum is greater (or less) than Integer.MAX_VALUE 
(MIN_VALUE). The answer will wrap, but will be consistent.

 