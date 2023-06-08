import img from '../../../assets/IMG.jpg'
import './ImageBox.css';

function ImgBox(){
    return(
      <div className="imageBox">
          <img src={img}></img>
        </div>
    );
  }

  export default ImgBox;