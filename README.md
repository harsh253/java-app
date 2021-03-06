#Windows commands

Step 1: Firstly kill all running mongodb instance

`net stop MongoDB`

Step  2: Create a folder where the replicated dbs will be kept. So for example, if I want to store it in folder in desktop, I'll create a folder as mentioned next.
For storing in a folder with directory structure as "/mongo/data" , we will create 3 folders(replicas) inside "data" folder, "rs0", "rs1" , "rs2" and use the following commands in cmd.

`mongod --dbpath "<path/to/rs0>" --replSet <name of the set> --port <port number for this replica>`

`mongod --dbpath "<path/to/rs1>" --replSet <name of the set> --port <port number for this replica>`

`mongod --dbpath "<path/to/rs2>" --replSet <name of the set> --port <port number for this replica>`

Here, the **name of the set remains same** throughout because all three dbs are instances of the same replica set. Port will be different for all instances

Step 3: Configure any one of the above instances for replication using following command in cmd.

`mongo --port <port number of any one of the above>`

`config = {_id: "<name of the set>" , members: [{_id:0 , host:"localhost:<port number>"}, {_id:1 , host:"localhost:<port number>"}, {_id:3 , host:"localhost:<port number>"}]`

`rs.initiate(config)`

Now, all replicas have been configured with 1 being PRIMARY and other 2 being SECONDARY

Step 4: To perform read operations for a particular replica, open a new terminal and type

`mongo --port <port number>`

`rs.slaveOk()`
