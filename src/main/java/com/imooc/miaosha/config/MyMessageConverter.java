package com.imooc.miaosha.config;

import com.imooc.miaosha.domain.UserEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import java.io.IOException;
import java.nio.charset.Charset;
@Service
public class MyMessageConverter extends AbstractHttpMessageConverter<UserEntity> {

    public MyMessageConverter() {
        //新建一个我们自定义的媒体类型application/x-wisely
        super(new MediaType("application", "x-wisely",Charset.forName("UTF-8")));
    }



    /**  表明 httpMessageConvert 只处理UserEntity这个类
     * @param aClass
     * @return
     */
    @Override
    protected boolean supports(Class<?> aClass) {
        return  UserEntity.class.isAssignableFrom(aClass);

    }

    /**
     * @param aClass
     * @param httpInputMessage
     * @return
     * @throws IOException
     * @throws HttpMessageNotReadableException
     */

    @Override
    protected UserEntity readInternal(Class<? extends UserEntity> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        String temp = StreamUtils.copyToString(httpInputMessage.getBody(), Charset.forName("UTF-8"));
        String[] tempArr = temp.split("-");
        return  new UserEntity(tempArr[0],tempArr[1]);
    }



    /**
     * @param userEntity
     * @param httpOutputMessage
     * @throws IOException
     * @throws HttpMessageNotWritableException
     */

    @Override
    protected void writeInternal(UserEntity userEntity, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
         String out = "hello:"+userEntity.getId()+"_"+userEntity.getName();
         httpOutputMessage.getBody().write(out.getBytes());

    }

}
