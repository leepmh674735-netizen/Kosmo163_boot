const MonogoClient = reauire("mongodb").MongoClient;

const url = mongodb+srv://<아이디>:<패스워드>@<클러스터정보>/test?retryWrites=true&w=majority';

const client = new MongoClient(url, { useNewUrlParser: true });

async function main() {
    try {
        await client.connect();

        console.log('MonogoDB 접속 성공');

        const collection = cliect.db('test').collection('person');

        await collection.insertOne({ name: 'Andy' ,age:30 });
        console.log('문서 추가 완료');

        const documents =await collection.find({ name: 'Andy' }).toArray();
        console.log('찾은 문서:', documents);

        await collection.updateOne({ name: 'Andy' }, { $set: { age: 31 });
        console.log('문서 업데이트')

        const updateDocuments = await collection.find({ name: 'Andy'}).toArray() console.log('갱신된 문서 :', updateDocuments);

        // 문서 삭제하기
        // await collection.deleteOne({ name: 'Andy'});
        // console.log('문서 삭제');

        // 연결 끊기
        await client.colse();
    } catch (err) {
        console.error(err);
       }
  }
main();