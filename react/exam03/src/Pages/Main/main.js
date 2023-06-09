import { Col, Row } from "reactstrap";
import PhotoCard from "./PhotoCard/PhotoCard";




function Main() {
    return (
        <Row>
            <Col xs="12" sm="9">
                <Row>
                    <Col xs="12" sm="6" md="4">
                        <PhotoCard random="1"></PhotoCard>
                    </Col>
                    <Col xs="12" sm="6" md="4">
                        <PhotoCard random="2"></PhotoCard>
                    </Col>
                    <Col xs="12" sm="6" md="4">
                        <PhotoCard random="3"></PhotoCard>
                    </Col>
                    <Col xs="12" sm="6" md="4">
                        <PhotoCard random="4"></PhotoCard>
                    </Col>
                </Row>
            </Col>
            <Col xs="12" sm="3">

            </Col>
        </Row>
    );
}

export default Main;