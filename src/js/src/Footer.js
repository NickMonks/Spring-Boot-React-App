import React from 'react';
import Container from './Container';
import { Button } from 'antd';
import './Footer.css';
import Avatar from 'antd/lib/avatar/avatar';

const Footer = (props) => (
    <div className='footer'>
        <Container>
            {props.numberOfStudents !== undefined ? 
                <Avatar 
                style={{backgroundColor: '#f56a00', marginRight: '10px'}}
                size='large'>{props.numberOfStudents}</Avatar> : null}
            <Button onClick={() => props.handleAddStudentClickEvent()} type='primary'> Add new student + </Button>
        </Container>
    </div>
);

export default Footer;