import style from "./Board.module.css";

const posts = [
    { id: 1, author: 'User1', title: 'First Post', date: '2023-01-01', views: 100 },
    { id: 2, author: 'User2', title: 'Second Post', date: '2023-01-02', views: 200 },
    { id: 3, author: 'User3', title: 'Third Post', date: '2023-01-03', views: 150 }
  ];

  const result = posts.map((e, index)=>{
    return <tr> <td>{e.id}</td> <td>{e.author}</td> <td>{e.title}</td> 
    <td>{e.date}</td> <td>{e.views}</td> </tr> 
  })



function Board() {
    return (
      <div className={style.Board}>
        <table className={style.Table}>
            <tr className={style.Tr}>
                <th>글번호</th>
                <th>작성자</th>
                <th>제목</th>
                <th>작성일</th>
                <th>조회수</th>
            </tr>
            {result}
            
        </table>
      </div>
    );
  }
  
  export default Board;