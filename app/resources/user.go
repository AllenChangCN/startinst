package resources

import (
	"github.com/gin-gonic/gin"
	"fmt"
	"../util"
)

type UserResource struct {
}

func (r *UserResource) FetchAllUsers(c *gin.Context) {

	id, idString := util.SnowflakeID()
	fmt.Print(id)
	fmt.Print(idString)
	c.JSON(200, idString)
	return
}