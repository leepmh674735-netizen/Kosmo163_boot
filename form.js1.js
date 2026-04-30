const add = document.getElementById("add");
const result = document.getElementById("result");
const create = document.getElementById("create");

let count = 0;

// [수정 1] 전역 click이 아닌 'add' 버튼에 이벤트 리스너를 할당해야 합니다.
add.addEventListener("click", function() {
    if (count >= 5) { // 5개까지만 허용 (0, 1, 2, 3, 4)
        alert('최대 5개만 가능');
        return;
    }

    let d = document.createElement("div");
    d.classList.add("input-group", "mb-2"); // 디자인을 위한 클래스 추가 (선택사항)

    let i = document.createElement("input");
    i.type = "file";
    i.name = "attach";
    i.classList.add("form-control");

    let b = document.createElement("button");
    b.type = "button";
    b.innerText = "X";
    b.classList.add("btn", "btn-danger", "del"); // 스타일을 위해 클래스 추가

    d.append(i);
    d.append(b);
    result.prepend(d);

    count++;
});

// [수정 2] 삭제 기능 (이벤트 위임)
result.addEventListener("click", function(e) {
    if (e.target.classList.contains("del")) {
        e.target.parentElement.remove();
        count--;
    }
});

// [수정 3] 주석 처리된 Fetch 부분의 오타 수정 (FormData)
create.addEventListener("click", () => {
    let form = new FormData(); // 'ForData' -> 'FormData'로 수정
    form.append("boardTitle", "ajax title");
    form.append("boardWriter", "ajax writer");
    form.append("boardContents", "ajax contents");

    // 만약 파일들도 함께 보내야 한다면 추가 로직이 필요합니다.
    // let files = document.getElementsByName("attach");
    // files.forEach(f => form.append("files", f.files[0]));

    fetch("./create", {
        method: "POST",
        body: form
    })
    .then(res => res.text())
    .then(res => console.log(res))
    .catch(err => console.error("Error:", err));
});