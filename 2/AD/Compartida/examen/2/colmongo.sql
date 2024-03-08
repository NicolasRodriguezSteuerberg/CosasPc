
use test
db.arbores.drop()
var arb=
[
{_id: "maceira",prodm:20},
{_id: "pereira",prodm:60},
{_id: "nispereiro",prodm:30},
{_id: "ameixeira",prodm:25},
{_id: "laranxeira",prodm:22},
{_id: "cerdeira",prodm:40},
{_id: "figueira",prodm:23}
]
db.propietarios.drop();
var prop=
[
{_id:"36555532J",prodanoanterior:15000, total:0},
{_id:"36776688M",prodanoanterior:200000,total:0},
{_id:"36832098L",prodanoanterior:30000,total:0},
{_id:"36112222K",prodanoanterior:220000,total:0},
{_id:"36229944M",prodanoanterior:30000,total:0},
{_id:"36912987T",prodanoanterior:20000,total:0}
]

db.arbores.insert(arb)
db.propietarios.insert(prop)

