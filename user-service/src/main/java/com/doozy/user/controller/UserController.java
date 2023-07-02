package com.doozy.user.controller;

import com.doozy.user.entity.Book;
import com.doozy.user.entity.Bookmarks;
import com.doozy.user.entity.Playlist;
import com.doozy.user.entity.User;
import com.doozy.user.error.BookNotFoundException;
import com.doozy.user.error.BookNotLikedException;
import com.doozy.user.error.UserNotFoundException;
import com.doozy.user.service.UserService;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class UserController {

//        ✔   - `/api/user/profile`
//        ✔   - `/api/user/profile/update`
//        x    - `/api/user/library`
//        x    - `/api/user/library/add`
//        x    - `/api/user/library/remove`
//        x    - `/api/user/followers`
//        x    - `/api/user/following`
//        x    - `/api/user/follow`
//        x    - `/api/user/unfollow`
//        ✔    - `/api/user/liked-audiobooks`
//        ✔    - `/api/user/like`
//        ✔    - `/api/user/unlike`
//        x    - `/api/user/comments`
//        x    - `/api/user/comments/add`
//        x    - `/api/user/comments/delete`
//        ✔    - `/api/user/playlists`
//        ✔    - `/api/user/playlists/create`
//        ✔    - `/api/user/playlists/:id`
//        ✔    - `/api/user/playlists/:id/add`
//        ✔    - `/api/user/playlists/:id/remove`
//        x    - `/api/user/current`
//        x    - `/api/user/current/add`
//        x    - `/api/user/current/remove`
//        x    - `/api/user/current/progress`
//        x    - `/api/user/current/recommend-next`
//        ✔    - `/api/user/bookmarks`
//        ✔    - `/api/user/bookmarks/add`
//        ✔    - `/api/user/bookmarks/remove`

    private UserService userService;

    @SneakyThrows
    @GetMapping("/api/user/profile")
    public User getUserProfile(@RequestParam(name="uid") Long uid){
        return userService.getUserProfile(uid);
    }

    @PutMapping("/api/user/profile")
    public User updateUserProfile(@RequestParam("uid")Long uid,@RequestBody User newUser) throws UserNotFoundException {
        return userService.updateUserProfile(uid,newUser);
    }

    @GetMapping("/api/user/liked-audiobooks")
    public List<Book> getLikedBooks(@RequestParam(name="uid") Long uid) throws UserNotFoundException {
        return userService.getAllLikedBooks(uid);
    }

    @PostMapping("/api/user/like")
    public Book likeBook(@RequestParam(name="uid")Long uid,@RequestParam(name="bid") Long bid) throws UserNotFoundException, BookNotFoundException {
        return userService.likeBook(uid,bid);
    }

    @PostMapping("/api/user/unlike")
    public Book unlikeBook(@RequestParam(name="uid")Long uid,@RequestParam(name="bid") Long bid) throws UserNotFoundException, BookNotLikedException, BookNotFoundException {
        return userService.unlikeBook(uid,bid);
    }

    @GetMapping("/api/user/playlists")
    public List<Playlist> getAllPlaylist(@RequestParam(name="uid") Long uid) throws UserNotFoundException {
        return userService.getAllPlaylist(uid);
    }

    @PostMapping("/api/user/playlists/create")
    public Playlist createNewPlaylist(@RequestParam(name = "uid")Long uid,@RequestBody Playlist playlist){
        return userService.createPlaylist(uid,playlist);
    }

    @GetMapping("/api/user/playlists/{id}")
    public Playlist getPlaylist(@PathVariable("id")UUID playlistId){
        return null;
    }

    @GetMapping("/api/user/bookmarks")
    public List<Bookmarks> getAllBookmarks(@RequestParam(name="uid") Long uid){
        return null;
    }

    @PostMapping("/api/user/bookmarks/add")
    public Bookmarks createBookmark(@RequestBody Bookmarks bookmark){
        return null;
    }

    @DeleteMapping("/api/user/bookmarks/remove")
    public String deleteBookmark(@RequestBody Bookmarks bookmark){
        return null;
    }


}
