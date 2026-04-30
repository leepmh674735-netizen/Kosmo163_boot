const all = document.getElementById("all");
const selectdel = document.getElementById("selectdel");
const list = document.getElementById("list");

// 1. 초기 리스트 로드
getList();

function getList() {
    fetch("./cartlist")
        .then(r => r.text())
        .then(r => {
            list.innerHTML = r.trim();
            // 리스트가 갱신되면 전체 선택 체크박스 초기화
            if(all) all.checked = false;
        });
}

// 2. 선택 삭제 버튼
selectdel.addEventListener("click", () => {
    // 체크박스는 동적으로 생성되므로 클릭 시점에 다시 찾아야 합니다.
    const chs = document.querySelectorAll(".ch:checked");
    
    if (chs.length === 0) {
        alert("삭제할 항목을 선택해주세요.");
        return;
    }

    if (!confirm("선택한 상품을 삭제하시겠습니까?")) return;

    let pn = new URLSearchParams();
    chs.forEach((c) => {
        pn.append("productNum", c.getAttribute("data-pn"));
    });

    fetch("./delete", {
        method: "POST",
        body: pn
    })
    .then(r => r.text())
    .then(r => {
        if (r.trim() > 0) {
            getList();
        } else {
            alert("삭제 실패");
        }
    });
});

// 3. 이벤트 위임 (목록 내부의 삭제 버튼 및 체크박스 처리)
list.addEventListener("click", (e) => {
    // [개별 삭제 버튼 클릭 시]
    if (e.target.classList.contains("del")) {
        if (!confirm("정말 삭제하시겠습니까?")) return;

        // 버튼 바로 앞의 요소(체크박스 등)에서 data-pn 가져오기
        let pn = e.target.previousElementSibling.getAttribute("data-pn");
        let p = new URLSearchParams();
        p.append("productNum", pn);

        fetch("./delete", {
            method: "POST",
            body: p
        })
        .then(r => r.text())
        .then(r => {
            if (r.trim() > 0) {
                getList();
            } else {
                alert('삭제 실패');
            }
        });
    }

    // [개별 체크박스 클릭 시 전체 선택 상태 동기화]
    if (e.target.classList.contains("ch")) {
        const chs = document.querySelectorAll(".ch");
        const checkedChs = document.querySelectorAll(".ch:checked");
        
        all.checked = (chs.length === checkedChs.length);
    }
});

// 4. 전체 선택 체크박스
all.addEventListener("click", () => {
    const chs = document.querySelectorAll(".ch");
    chs.forEach((c) => {
        c.checked = all.checked;
    });
});