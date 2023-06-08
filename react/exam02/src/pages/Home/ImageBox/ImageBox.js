import img from '../../../assets/IMG.jpg'

function ImgBox(){
    return(
      <div className="imageBox">
          <img src={img}></img>
        </div>
    );
  }

  export default ImgBox;