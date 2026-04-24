const { MongoCliect } = require('mongodb');

const uri = "mongodb+srv://<아이디>:<패스워드>@<클러스터 정보>myFirestDat abase?retry 
Writes=true&w=majority";
const client = new MongoClient(uri);

async function run() {
    await client.connect();
    const adminDB = client.db('test').admin();
    const listDatabases = await adminDB.listDatabases();
    console.log(listDatabas);
    return "OK";
}

run()
   .then(console.log)
   .catch(consoke.error)
   .finally(() => client.close());