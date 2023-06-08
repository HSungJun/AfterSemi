import style from './body.module.css';


function Body(){
    return(
        <div className={style.Body}>
            <div className={style.Contents}>Contents</div>
            <div className={style.Aside}>Aside</div>
        </div>
    );
}

export default Body;