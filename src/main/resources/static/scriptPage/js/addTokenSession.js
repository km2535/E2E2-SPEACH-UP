const ONE_HOUR_MILLISECOND = 3600000;

const queryString = window.location.search;
const urlParams = new URLSearchParams(queryString);
const token = urlParams.get('token');
if(token != null ){
    setItemWithExpiry("jwtToken",token, ONE_HOUR_MILLISECOND );
    window.location.href = "/";
}



function setItemWithExpiry(key, value, ttl) {
    const now = new Date();

    // ttl은 밀리초로 표현된 유효 시간입니다.
    const expiry = now.getTime() + ttl;

    const item = {
        value: value,
        expiry: expiry
    };

    localStorage.setItem(key, JSON.stringify(item));
}