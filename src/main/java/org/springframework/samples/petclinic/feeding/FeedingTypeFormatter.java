package org.springframework.samples.petclinic.feeding;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class FeedingTypeFormatter implements Formatter<FeedingType>{

    @Autowired

    private FeedingService feedingService;

    @Override
    public String print(FeedingType object, Locale locale) {
        
        return object.getName();
    }

    @Override
    public FeedingType parse(String text, Locale locale) throws ParseException {
        FeedingType findFeedingType = this.feedingService.getFeedingType(text);

        try {
   
            if(findFeedingType.getName().equals(text)){
                return findFeedingType;
            }
            
        } catch (NullPointerException e) {
            throw new ParseException("This is not a feeding type", 0);
        }
        return findFeedingType;
    }
    
}
