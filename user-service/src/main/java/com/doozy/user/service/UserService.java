package com.doozy.user.service;

import com.doozy.user.entity.Book;
import com.doozy.user.entity.Playlist;
import com.doozy.user.entity.User;
import com.doozy.user.error.BookNotFoundException;
import com.doozy.user.error.BookNotLikedException;
import com.doozy.user.error.UserNotFoundException;

import java.util.List;

public interface UserService {
    User getUserProfile(Long uid) throws UserNotFoundException;

    User updateUserProfile(Long uid, User newUser) throws UserNotFoundException;

    List<Book> getAllLikedBooks(Long uid) throws UserNotFoundException;

    Book likeBook(Long uid,Long bid) throws UserNotFoundException, BookNotFoundException;

    Book unlikeBook(Long uid, Long bid) throws UserNotFoundException, BookNotFoundException, BookNotLikedException;

    List<Playlist> getAllPlaylist(Long uid) throws UserNotFoundException;

    Playlist createPlaylist(Long uid, Playlist playlist);
}
