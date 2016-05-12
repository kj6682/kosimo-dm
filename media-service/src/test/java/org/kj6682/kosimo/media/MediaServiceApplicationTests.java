package org.kj6682.kosimo.media;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Main.class)
@WebAppConfiguration
@Ignore
public class MediaServiceApplicationTests {

    Media book;
   
    @Autowired
    MediaRepository mediaRepo;


    @Autowired
    MediaController accountCtrl;

    @Before
    public void init() {
        book = new Media();

        mediaRepo.save(book);

    }

}
