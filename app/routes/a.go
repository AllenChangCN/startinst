package routes

import (
	"github.com/gin-gonic/gin"
	"../middleware"
)

func Register(r *gin.Engine) {

	// Auth
	auth := r.Group("")
	Auth(auth)

	// User
	user := r.Group("/api/v1/user", middleware.Auth())
	User(user)

	// Page
	page := r.Group("/api/v1/page", middleware.Auth())
	Page(page)
}
