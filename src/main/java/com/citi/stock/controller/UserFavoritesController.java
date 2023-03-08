package com.citi.stock.controller;

import com.auth0.jwt.JWT;
import com.citi.stock.entity.UserFavoritesRelation;
import com.citi.stock.service.IUserFavoritesRelationService;
import com.citi.stock.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/api/favorites")
@RestController
//@CrossOrigin
public class UserFavoritesController extends BaseController {
    @Autowired
    private IUserFavoritesRelationService iUserFavoritesRelationService;

    @GetMapping
    public List<UserFavoritesRelation> getAllFavoritesByUid(HttpServletRequest request){
        // 从token中拿到用户id
        String token = request.getHeader("token");
        Integer uid = JWT.decode(token).getClaim("userId").asInt();

        // 根据uid查找收藏列表
        return iUserFavoritesRelationService.getFavoritesByUid(uid);
    }

    @PostMapping("/{stockCode}")
    public JsonResult<Void> addOneFavorite(HttpServletRequest request,
                                     @PathVariable("stockCode") String stockCode){
        Integer uid = JWT.decode(request.getHeader("token")).getClaim("userId").asInt();

        iUserFavoritesRelationService.addOneFavorite(
                UserFavoritesRelation.builder()
                        .userfavoritesUserId(uid)
                        .userfavoritesStockCode(stockCode)
                        .build());
        return new JsonResult<>(200);
    }

    @DeleteMapping("/{stockCode}")
    public JsonResult<Void> cancelFavorite(HttpServletRequest request,
                                           @PathVariable("stockCode") String stockCode){
        Integer uid = JWT.decode(request.getHeader("token")).getClaim("userId").asInt();

        iUserFavoritesRelationService.deleteByUidAndCode(
                UserFavoritesRelation.builder()
                        .userfavoritesUserId(uid)
                        .userfavoritesStockCode(stockCode)
                        .build());
        return new JsonResult<>(200);
    }
}
