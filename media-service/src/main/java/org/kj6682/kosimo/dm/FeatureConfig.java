package org.kj6682.kosimo.dm;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@RefreshScope
@Configuration
class FeatureConfig {

    @Value("${media.find}")
    Boolean find;

    @Value("${media.findAll}")
    Boolean findAll;

    @Value("${media.findByTitle}")
    Boolean findByTitle;

    @Value("${media.findByAuthor}")
    Boolean findByAuthor;

    @Value("${media.findByType}")
    Boolean findByType;

    @Value("${media.create}")
    Boolean create;

    @Value("${media.delete}")
    Boolean delete;

    Boolean check(String arg){

        if(arg.equals("find"))
            return find;

        if(arg.equals("findAll"))
            return findAll;

        if(arg.equals("findByTitle"))
            return findByTitle;

        if(arg.equals("findByAuthor"))
            return findByAuthor;

        if(arg.equals("findByType"))
            return findByType;

        if(arg.equals("create"))
            return create;

        if(arg.equals("delete"))
            return delete;

        return false;
    }
}
