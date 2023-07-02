package com.doozy.user.service;

import com.doozy.user.entity.Book;
import com.doozy.user.entity.Playlist;
import com.doozy.user.entity.User;
import com.doozy.user.error.BookNotFoundException;
import com.doozy.user.error.BookNotLikedException;
import com.doozy.user.error.UserNotFoundException;
import com.doozy.user.repository.BookRepository;
import com.doozy.user.repository.UserRepository;
import lombok.SneakyThrows;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class UserServiceImpl implements UserService{

    private UserRepository userRepo;
    private BookRepository bookRepo;

    @Override
    public User getUserProfile(Long uid) throws UserNotFoundException {
        Optional<User> user = userRepo.findById(uid);

        if(!user.isPresent()) throw new UserNotFoundException("User Not Found!");

        return user.get();
    }

    @Override
    public User updateUserProfile(Long uid, User newUser) throws UserNotFoundException {
        Optional<User> opt= userRepo.findById(uid);

        if(opt.isEmpty()) throw new UserNotFoundException("User Not Found!");
        User oldUser = opt.get();

        if(Objects.nonNull(oldUser.getFName()) && !"".equalsIgnoreCase(oldUser.getFName()))
            oldUser.setFName(newUser.getFName());

        if(Objects.nonNull(oldUser.getLName()) && !"".equalsIgnoreCase(oldUser.getLName()))
            oldUser.setLName(newUser.getLName());

        if(Objects.nonNull(oldUser.getEmail()) && !"".equalsIgnoreCase(oldUser.getEmail()))
            oldUser.setEmail(newUser.getEmail());

        return userRepo.save(oldUser);

    }

    @Override
    public List<Book> getAllLikedBooks(Long uid) throws UserNotFoundException {
        Optional<User> opt= userRepo.findById(uid);

        if(opt.isEmpty()) throw new UserNotFoundException("User Not Found!");
        User user = opt.get();

        return user.getBooksLiked();
    }

    @Override
    public Book likeBook(Long uid,Long bid) throws UserNotFoundException, BookNotFoundException {
        Optional<User> optionalUser= userRepo.findById(uid);
        Optional<Book> optionalBook= bookRepo.findById(bid);

        if(optionalUser.isEmpty()) throw new UserNotFoundException("User Not Found!");
        User user = optionalUser.get();

        if(optionalBook.isEmpty()) throw new BookNotFoundException("Book Not Found!");
        Book book = optionalBook.get();


        if(Objects.nonNull(user.getBooksLiked())) {
            List<Book> likedBooks = user.getBooksLiked();
            likedBooks.add(book);
            user.setBooksLiked(likedBooks);
        }

        userRepo.save(user);
        return book;
    }

    @Override
    public Book unlikeBook(Long uid, Long bid) throws UserNotFoundException, BookNotFoundException, BookNotLikedException {
        Optional<User> optionalUser = userRepo.findById(uid);
        Optional<Book> optionalBook= bookRepo.findById(bid);

        if(optionalUser.isEmpty()) throw new UserNotFoundException("User Not Found!");
        User user = optionalUser.get();

        if(optionalBook.isEmpty()) throw new BookNotFoundException("Book Not Found!");
        Book book = optionalBook.get();


        if(Objects.nonNull(user.getBooksLiked())) {
            List<Book> likedBooks = user.getBooksLiked();
            if(!likedBooks.contains(book)) throw new BookNotLikedException("Book Not Liked!");
            likedBooks.remove(book);
            user.setBooksLiked(likedBooks);
        }

        userRepo.save(user);
        return book;
    }

    @Override
    public List<Playlist> getAllPlaylist(Long uid) throws UserNotFoundException {
        Optional<User> optionalUser = userRepo.findById(uid);
        if(optionalUser.isEmpty()) throw new UserNotFoundException("User Not Found!");
        User user = optionalUser.get();

        List<Playlist> playlistList = user.getPlaylistList();
        return playlistList;
    }

    @Override
    public Playlist createPlaylist(Long uid, Playlist playlist) {
        Optional<User> optionalUser = userRepo.findById(uid);
        if(optionalUser.isEmpty()) throw new UserNotFoundException("User Not Found!");
        User user = optionalUser.get();

        List<Book> playlistBooks = playlist.getPlaylistBooks();
        for (Book i:
             playlistBooks) {
            Example<Book> sExample = (Example<Book>) i;
            if(!bookRepo.exists(sExample))
        }

        return null;
    }


}
