
function showMentorFields(selectedvalue){  
    if(selectedvalue=='Mentor'){
    document.getElementById('OtherMentorFields').style.display='block';
    }
    if(selectedvalue=='Student'){
        document.getElementById('OtherMentorFields').style.display='none';
    }
    

}