package org.kj6682.kosimo.dm;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@RefreshScope
@Configuration
class FeatureConfig {

    @Value("${account.find}")
    Boolean find;

    @Value("${account.findAll}")
    Boolean findAll;

    @Value("${account.findByOwner}")
    Boolean findByOwner;

    @Value("${account.create}")
    Boolean create;

    @Value("${account.delete}")
    Boolean delete;

    @Value("${account.transfer}")
    Boolean transfer;

    Boolean check(String arg){

        if(arg.equals("find"))
            return find;

        if(arg.equals("findAll"))
            return findAll;

        if(arg.equals("findByOwner"))
            return findByOwner;

        if(arg.equals("create"))
            return create;

        if(arg.equals("delete"))
            return delete;

        if(arg.equals("transfer"))
            return transfer;

        return false;
    }
}
