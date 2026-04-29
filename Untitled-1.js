const add = document.getElementById("add");
const result = document.getElementById("result");

let count = 0;

addEventListener("click",function(){
    if(count >=5){
        alert('최대 5개만 가능합니다');
        return;
};
const d = document.createElement("div");
;d.classList.add("mb-2","d-flex");
const i = document.createElement("input");
i.type = "file";
i.name ="attach";
i.classList.add("form-control");
const b = document.createElement("button");
b.type = "button";
b.innerText = "x";
b.classList.add("del","btn",'btn-danger","ms-2");
    d.append(i);
    d.append(b);
    result.prepend(d);
    count++;
});
result.addEventListener("click", function(e) 
    this.id(e.target.classList.contains("del")) {
        e.target.parentElement,remove();
        count--;
    }
});
