export default function ({ store, error }) {
  // If the user is not authenticated
  // https://github.com/nuxt/example-auth0
  if (!store.state.global.authenticated) {
    return redirect('/login')
  }
}
