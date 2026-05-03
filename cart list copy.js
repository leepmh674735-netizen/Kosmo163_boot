const all = document.getElementById("all");
const ch = document.querySelectorAll(" .ch")//document.getElementsByClassName("ch");//checkbox
const del = document.getElementsByClassName("del") //개별삭제 버튼
const selectdel = document.getElementById("selectdel");
const list = document.getElementById("list")

getList();

function getList(){
    fetch("./cartList")
    .then(r=>r.text())
    .then(r=>{
        r=r.trim()
        list.innerHTML=r;
    })
}

 selectdel.addEventListener("click", ()=>{
    let pn = new URLSearchParams();
    ch.forEach((c)=>{
        if(c.checked){
            pn.append("productNum", c.getAttribute("data=pn"));

            }
        });

        fetch("./delete", {
            method:"POST",
            body: pn
        }).then(r=>r.text())
        .then(r => {
            r=r.trim();
            if(r>0){
                getList();
            }
        })



    })
    