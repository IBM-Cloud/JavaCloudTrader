<%


        Cookie[] cookies = request.getCookies();

        for(int i=0;i<cookies.length;i++){

            if(!cookies[i].getName().equals("JSESSIONID")){

                cookies[i].setMaxAge(-1);
                cookies[i].setValue(null);

                response.addCookie(cookies[i]);
            }
        }


%>