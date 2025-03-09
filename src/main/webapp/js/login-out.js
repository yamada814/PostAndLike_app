
//いいねを押すと、いいね数を更新 & ハートの色を切り替える
const likeBtns = document.querySelectorAll(".likeBtn");
likeBtns.forEach(likeBtn => {
	likeBtn.addEventListener("click", async () => { 
		const boardId = likeBtn.getAttribute("data-board-id");
		const boardLoginId = likeBtn.getAttribute("data-board-LoginId");
		const url = `/PostAndLikeApp/BoardLikeItem.action?boardId=${boardId}&boardLoginId=${boardLoginId}`;
		try{
			const res = await fetch(url);
			if(res.ok){
				const data = await res.json();			
				const likes = data.likes;
				const heartFill = data.heartFill;
				
				//いいね数の更新
				const likeCountEl = likeBtn.parentElement.querySelector(".likeCount");
				likeCountEl.textContent = likes;
				//ハートの塗りつぶしを切り替え
				const heart = likeBtn.firstElementChild;
				if(heartFill){
					heart.classList.replace("bi-heart","bi-heart-fill");
				}else{
					heart.classList.replace("bi-heart-fill","bi-heart");
				}
			}
		}catch(error){
			console.error(error);
		}
	})
});
//いいね数をクリックすると いいねした人の一覧を非同期で表示
const likeCounts = document.querySelectorAll(".likeCount");
likeCounts.forEach(likeCount => {
	likeCount.addEventListener("click",async () => {
		const boardId = likeCount.getAttribute("data-board-id");
		try{
			const res = await fetch(`/PostAndLikeApp/WhoLikes.action?boardId=${boardId}`);
			if(res.ok){
				const data = await res.json();
				console.log(data.loginId);
				const whoLikesList = likeCount.parentElement.querySelector(".whoLikesList");
				if(!whoLikesList.classList.toggle("hidden")){					
					const ul = whoLikesList.querySelector("ul");
					ul.innerHTML="";
					data.loginIdList.forEach(loginId => {
						const li = document.createElement("li");
						li.textContent = loginId;					
						ul.appendChild(li);
					});			
				}
			}
		}catch(error){
			console.error(error);
		}
	})	
})

//postボタンをクリックでイベント処理
//サーブレットにfetchして投稿したデータを取得する
//取得したデータをarticleのinnerHTMLに埋め込んでツリーに追加
//articleをmainの先頭に追加

const postbtn = document.getElementById("postbtn");
const main = document.querySelector("main");
const hiddenArticle = document.querySelector(".hiddenArticle");
postbtn.addEventListener("click",async () => {
	try{
		const res = await fetch("PostAndLikeApp/BoardPost.action");
		if(res.ok){
			const data = await res.json();
			const {loginId,mydate,contents,likes} = data;
			
			document.getElementById("hiddenLoginId").textContent = loginId;
			document.getElementById("hiddenMydate").textContent = mydate;
			document.getElementById("hiddenContents").textContent = contents;
			document.getElementById("hiddenLikes").textContent = likes;
			
			hiddenArticle.removeAttribute("class");		
		}
	}catch(error){
		console.error(error);
	}
 })
/*  ダメだったやつ
 const article = document.createElement("article");
 			article.innerHTML = `
 			    <div class="articleHead">
 			        <div><a href="AccountPage.action?account=${loginId}">${loginId}</a></div>
 			        <div class="date">${mydate}</div>
 			    </div>
 			    <div class="contents">${contents}</div>
 			    <div class="articleFoot">
 			        <div><i class="bi bi-heart"></i>：${likes}</div>
 			    </div>
 			`;
 			main.prepend(article);*/

//できなかった
//削除ボタンを非同期処理
/*
const clearBtns = document.querySelectorAll(".clearBtn");
clearBtns.forEach(clearBtn => {
	clearBtn.addEventListener("click", async () =>{
		const boardId = clearBtn.getAttribute("data-board-id");
		const url = `/ExercizeServlet7/BoardClearItem.action?boardId=${boardId}`;
		try{
			const res = await fetch(url);
			if(res.ok){
				
			}
		}catch(error){
			console.error(error);
		}
	})
});
*/