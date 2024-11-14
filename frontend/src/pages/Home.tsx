export default function Home() {
  return (
    <section className="home">
      <div className="home-logo">
        <img src="" alt="" className="home-logo__img" />
        <h1 className="home-logo__title">Green Action</h1>
        <p className="home-logo__text">Engajando ações</p>
      </div>
      <div className="home-actions">
        <p className="home-actions__text">
          Reduza sua pegada de carbono e faça parte da mudança para um futuro
          sustentável
        </p>
        <button className="home-action__btn register">Comece Agora</button>
        <button className="home-action__btn login">Já tenho uma conta</button>
      </div>
      <p className="home__text">
        Receba sugestões personalizadas de acordo com o seu estilo de vida!
      </p>
    </section>
  );
}
