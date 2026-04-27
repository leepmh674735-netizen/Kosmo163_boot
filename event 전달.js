const btn = document.getElementById("btn");
const frm = document.getElementById("frm");
const id1 = document.getElementById("id1");
const id2 = document.getElementById("id2");
// 1. 선택자 ID를 명시해야 합니다. (예: "id1_sub")
const id1_sub = document.getElementById("id1_sub"); 

id2.addEventListener("click", function(e) {
    e.preventDefault();
    console.log("naver");
});

btn.addEventListener("click", function(e) {
    console.log(e);
    e.preventDefault();
    // 2. id1.onmouseenter가 정의되어 있어야 호출 가능합니다.
    if (id1.onmouseenter) {
        id1.onmouseenter();
    }
});

id1.addEventListener("click", function() {
    console.log("parent");
});

// 3. addEventLister -> addEventListener (철자 수정)
// 4. 익명 함수 인자에 'e'를 전달해야 stopPropagation 사용 가능
id1_sub.addEventListener("click", function(e) { 
    console.log("child");
    // 5. e.stopPropagation(); 뒤의 'N' 제거
    e.stopPropagation(); 
});