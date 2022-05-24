package com.stackroute.muzixservice.service;


/*
 * Service classes are used here to implement additional business logic/validation
 * This class has to be annotated with @Service annotation.
 * @Service - It is a specialization of the component annotation. It doesn't currently
 * provide any additional behavior over the @Component annotation, but it's a good idea
 * to use @Service over @Component in service-layer classes because it specifies intent
 * better. Additionally, tool support and additional behavior might rely on it in the
 * future.
 * */

import com.stackroute.muzixservice.domain.Track;
import com.stackroute.muzixservice.exception.TrackAlreadyExistsException;
import com.stackroute.muzixservice.exception.TrackNotFoundException;
import com.stackroute.muzixservice.repository.MuzixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MuzixServiceImpl implements  MuzixService{

    /*
     * Autowiring should be implemented for the MuzixRepository. (Use
     * Constructor-based autowiring) Please note that we should not create any
     * object using the new keyword.
     */
   private MuzixRepository musicRespository;

   @Autowired
    public MuzixServiceImpl(MuzixRepository musicRespository) {
        this.musicRespository = musicRespository;
    }

    /*
     * This method should be used to save a new track.Call the corresponding
     * method of Respository interface.
     */


    @Override
    public Track SaveTrackToWishList(Track track) throws TrackAlreadyExistsException {
        System.out.println(track.toString());
        if(musicRespository.findById(track.getTrackId()).isPresent())
        {
            throw new TrackAlreadyExistsException();
        }
       // System.out.println("Inside service method "+musicRespository.save(track));
        return musicRespository.save(track);
    }

    /*
     * This method should be used to delete an existing track.Call the
     * corresponding method of Respository interface.
     */

    @Override
    public boolean deleteTrackFromWishList(String id) throws TrackNotFoundException {
        if(musicRespository.findById(id).isPresent())
        {
            musicRespository.deleteById(id);

        }
        else{
            throw new TrackNotFoundException();
        }
        return true;
    }

    /*
     * This method should be used to update a existing track.Call the
     * corresponding method of Respository interface.
     */

    @Override
    public Track updateCommentForTrack(String comments, String id) throws TrackNotFoundException {
        if(musicRespository.findById(id).isPresent())
        {
            Track track=musicRespository.findById(id).get();
            track.setComments(comments);
            return musicRespository.save(track);
        }
        else{
            throw new TrackNotFoundException();
        }

    }

    @Override
    public List<Track> getAllTracksByArtistName(String artistName) throws TrackNotFoundException {
        return musicRespository.findAllTrackByArtistName(artistName);
    }

    /*
     * This method should be used to get all track.Call the corresponding
     * method of Respository interface.
     */

    @Override
    public List<Track> getAllTrackFromWishList() throws Exception {
        return musicRespository.findAll();
    }
}
