const all = document.getElementById("all");
const selectdel = document.getElementById("selectdel");
const list = document.getElementById("list");

// 초기 리스트 로드
getList();

/**
 * 1. 장바구니 리스트 로드
 */
function getList() {
    fetch("./cartlist")
        .then(r => r.text())
        .then(r => {
            list.innerHTML = r.trim();
            // 리스트를 새로 불러오면 전체 선택 체크박스를 해제해주는 것이 좋습니다.
            if (all) all.checked = false; 
        })
        .catch(err => console.error("리스트 로드 실패:", err));
}

/**
 * 2. 선택 삭제 (체크된 항목들 삭제)
 */
selectdel.addEventListener("click", () => {
    let pn = new URLSearchParams();
    let ch = document.querySelectorAll(".ch:checked"); // 처음부터 체크된 것만 선택

    if (ch.length === 0) {
        alert("삭제할 상품을 선택해주세요.");
        return;
    }

    if (!confirm("선택한 상품을 삭제하시겠습니까?")) return;

    ch.forEach((c) => {
        pn.append("productNum", c.getAttribute("data-pn"));
    });

    fetch("./delete", {
        method: "POST",
        body: pn
    })
    .then(r => r.text())
    .then(r => {
        if (r.trim() > 0) {
            alert("삭제 성공");
            getList();
        } else {
            alert("삭제 실패");
        }
    });
});

/**
 * 3. 리스트 내부 이벤트 (개별 삭제 및 개별 체크박스 감지)
 */
list.addEventListener("click", (e) => {
    // [개별 삭제]
    if (e.target.classList.contains("del")) {
        if (!confirm("정말 삭제하시겠습니까?")) return;

        // data-pn 속성을 가진 요소를 찾는 로직 (e.target 기준으로 탐색)
        let pn = e.target.getAttribute("data-pn") || e.target.previousElementSibling.getAttribute("data-pn");
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
        let chs = document.querySelectorAll(".ch"); // 전체 개별 체크박스
        let checkedChs = document.querySelectorAll(".ch:checked"); // 체크된 것들
        
        // 모든 체크박스가 체크되어 있다면 전체 선택 버튼도 체크
        all.checked = (chs.length === checkedChs.length);
    }
});

/**
 * 4. 전체 선택/해제 기능
 */
all.addEventListener("click", () => {
    let ch = document.querySelectorAll(".ch");
    ch.forEach((c) => {
        c.checked = all.checked;
    });
});