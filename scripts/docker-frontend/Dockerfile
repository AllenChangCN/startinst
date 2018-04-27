FROM eggplanet/nuxt

# replace something in nuxt.config.js
RUN sed -i -e 's/apiserver\.dev/apiserver.production/g' nuxt.config.js

RUN ./node_modules/.bin/nuxt build