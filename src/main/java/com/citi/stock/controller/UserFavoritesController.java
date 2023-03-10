package com.citi.stock.controller;

import com.auth0.jwt.JWT;
import com.citi.stock.entity.UserFavoritesRelation;
import com.citi.stock.service.IUserFavoritesRelationService;
import com.citi.stock.util.JsonResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/api/favorites")
@RestController
@Tag(name = "用户收藏管理接口", description = "用户收藏")
@Slf4j
//@CrossOrigin
public class UserFavoritesController extends BaseController {
    @Autowired
    private IUserFavoritesRelationService iUserFavoritesRelationService;

    @Operation(summary = "获取当前用户的所有收藏股票列表")
    @GetMapping
    public List<UserFavoritesRelation> getAllFavoritesByUid(HttpServletRequest request){
        // 从token中拿到用户id
        String token = request.getHeader("token");
        Integer uid = JWT.decode(token).getClaim("userId").asInt();
        log.info("Getting all favorites for user {}", uid);

        // 根据uid查找收藏列表
        return iUserFavoritesRelationService.getFavoritesByUid(uid);
    }

    @Operation(summary = "用户添加收藏")
    @PostMapping("/{stockCode}")
    public JsonResult<Void> addOneFavorite(HttpServletRequest request,
                                     @PathVariable("stockCode") String stockCode){
        Integer uid = JWT.decode(request.getHeader("token")).getClaim("userId").asInt();
        log.debug("User {} favorite {}",uid, stockCode);

        iUserFavoritesRelationService.addOneFavorite(
                UserFavoritesRelation.builder()
                        .userfavoritesUserId(uid)
                        .userfavoritesStockCode(stockCode)
                        .build());
        return new JsonResult<>(OK);
    }

    @Operation(summary = "用户取消收藏")
    @DeleteMapping("/{stockCode}")
    public JsonResult<Void> cancelFavorite(HttpServletRequest request,
                                           @PathVariable("stockCode") String stockCode){
        Integer uid = JWT.decode(request.getHeader("token")).getClaim("userId").asInt();
        log.debug("User {} un-favorite {}",uid, stockCode);

        iUserFavoritesRelationService.deleteByUidAndCode(
                UserFavoritesRelation.builder()
                        .userfavoritesUserId(uid)
                        .userfavoritesStockCode(stockCode)
                        .build());
        return new JsonResult<>(OK);
    }
}
