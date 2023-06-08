import style from './Navi.module.css';


function Navi(){
    return(
        <div className={style.Navi}>
            <div>Home</div>
            <div>About</div>
            <div>Contact</div>
        </div>
    );
}

export default Navi;