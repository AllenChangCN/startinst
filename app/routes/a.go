package routes

import (
	"github.com/gin-gonic/gin"
)

func Register(r *gin.Engine) {

	// Auth
	auth := r.Group("")
	Auth(auth)

	// User
	user := r.Group("/api/v1/user")
	User(user)

	// Page
	page := r.Group("/api/v1/page")
	Page(page)
}
